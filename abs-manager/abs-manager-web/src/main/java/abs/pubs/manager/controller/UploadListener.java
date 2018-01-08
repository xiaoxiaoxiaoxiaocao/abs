package abs.pubs.manager.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import abs.pubs.domain.UploadStatus;

public class UploadListener implements ProgressListener{
	
	   private HttpSession session;
	    public UploadListener(HttpSession session){
	        super();
	        this.session = session;
	        UploadStatus uploadStatus = new UploadStatus();
	        session.setAttribute("upload_status", uploadStatus);
	    }

	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		UploadStatus uploadSstatus = (UploadStatus) session.getAttribute("upload_status");
		uploadSstatus.setBytesRead(pBytesRead);
		uploadSstatus.setContentLength(pContentLength);
		uploadSstatus.setItems(pItems);
		uploadSstatus.setUseTime(System.currentTimeMillis()-uploadSstatus.getStartTime());
		uploadSstatus.setPercent((int) (100*pBytesRead/pContentLength));
		session.setAttribute("upload_status", uploadSstatus);
	}

}
