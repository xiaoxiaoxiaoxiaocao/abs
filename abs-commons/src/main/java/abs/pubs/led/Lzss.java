package abs.pubs.led;

public class Lzss {

	static int N = 4096;
	static int F = 18;
	static int THRESHOLD = 2;
	static int NIL = N;

	static int textsize = 0;
	static int codesize = 0;
	static int printcount = 0;
	static byte text_buf[];
	static int match_position, match_length;
	static int	lson[], rson[], dad[];

	public Lzss() {
		lson = new int[N + 1];
		rson = new int[N + 257];
		dad = new int[N + 1];
		text_buf = new byte[N + F - 1];
    }
	
	private static void InitTree()  /* initialize trees */
	{
		int  i;
		for (i = N + 1; i <= N + 256; i++) rson[i] = NIL;
		for (i = 0; i < N; i++) dad[i] = NIL;
	}

	private static void InsertNode(int r)
	{
		int  i, p, cmp;
		//unsigned char  *key;

		//key = &text_buf[r];  
		cmp = 1;  p = N + 1 + text_buf[r];
		rson[r] = lson[r] = NIL;  match_length = 0;
		for ( ; ; ) {
			if (cmp >= 0) {
				if (rson[p] != NIL) p = rson[p];
				else {  rson[p] = r;  dad[r] = p;  return;  }
			} else {
				if (lson[p] != NIL) p = lson[p];
				else {  lson[p] = r;  dad[r] = p;  return;  }
			}
			for (i = 1; i < F; i++)
				if ((cmp = text_buf[r+i] - text_buf[p + i]) != 0)  break;
			if (i > match_length) {
				match_position = p;
				if ((match_length = i) >= F)  break;
			}
		}
		dad[r] = dad[p];  lson[r] = lson[p];  rson[r] = rson[p];
		dad[lson[p]] = r;  dad[rson[p]] = r;
		if (rson[dad[p]] == p) rson[dad[p]] = r;
		else                   lson[dad[p]] = r;
		dad[p] = NIL;
	}

	private static void DeleteNode(int p)
	{
		int  q;
		
		if (dad[p] == NIL) return;
		if (rson[p] == NIL) q = lson[p];
		else if (lson[p] == NIL) q = rson[p];
		else {
			q = lson[p];
			if (rson[q] != NIL) {
				do {  q = rson[q];  } while (rson[q] != NIL);
				rson[dad[q]] = lson[q];  dad[lson[q]] = dad[q];
				lson[q] = lson[p];  dad[lson[p]] = q;
			}
			rson[q] = rson[p];  dad[rson[p]] = q;
		}
		dad[q] = dad[p];
		if (rson[dad[p]] == p) rson[dad[p]] = q;  else lson[dad[p]] = q;
		dad[p] = NIL;
	}

	public int Encode(byte[] ibuf, int istart, int isize, byte[] obuf, int ostart)
	{
		int i, c, len, r, s, last_match_length, code_buf_ptr;
		byte[] code_buf = new byte[17]; 
		byte mask;
		int x, x1;

		x=x1=0;
		InitTree();
		code_buf[0] = 0;
		code_buf_ptr = mask = 1;
		s = 0;  r = N - F;
		for (i = s; i < r; i++) text_buf[i] = ' ';
		for (len = 0; len < F && x<isize; len++)
			text_buf[r + len] = ibuf[istart+(x++)];
		if ((textsize = len) == 0) return 0;
		for (i = 1; i <= F; i++) InsertNode(r - i);
		InsertNode(r);
		do {
			if (match_length > len) match_length = len;
			if (match_length <= THRESHOLD) {
				match_length = 1;
				code_buf[0] |= mask;
				code_buf[code_buf_ptr++] = text_buf[r];
			} else {
				code_buf[code_buf_ptr++] = (byte) match_position;
				code_buf[code_buf_ptr++] = (byte)
					(((match_position >> 4) & 0xf0)
				  | (match_length - (THRESHOLD + 1)));
			}
			if ((mask <<= 1) == 0) {
				for (i = 0; i < code_buf_ptr; i++)
					obuf[ostart+x1++]=code_buf[i];
				codesize += code_buf_ptr;
				code_buf[0] = 0;  code_buf_ptr = mask = 1;
			}
			last_match_length = match_length;
			for (i = 0; i < last_match_length &&
					x<isize; i++) {
				c=ibuf[istart+x++];
				DeleteNode(s);		/* Delete old strings and */
				text_buf[s] = (byte)c;	/* read new bytes */
				if (s < F - 1) text_buf[s + N] = (byte)c;  /* If the position is
					near the end of buffer, extend the buffer to make
					string comparison easier. */
				s = (s + 1) & (N - 1);  r = (r + 1) & (N - 1);
					/* Since this is a ring buffer, increment the position
					   modulo N. */
				InsertNode(r);	/* Register the string in text_buf[r..r+F-1] */
			}
			//if ((textsize += i) > printcount) {
			//	printf("%12ld\r", textsize);  printcount += 1024;
			//}
			while (i++ < last_match_length) {
				DeleteNode(s);
				s = (s + 1) & (N - 1);  r = (r + 1) & (N - 1);
				len--;
				if (len > 0) InsertNode(r);
			}
		} while (len > 0);
		if (code_buf_ptr > 1) {
			for (i = 0; i < code_buf_ptr; i++) obuf[ostart+x1++]=code_buf[i];
			codesize += code_buf_ptr;
		}
		return x1;
	}
}