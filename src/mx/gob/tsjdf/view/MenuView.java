package mx.gob.tsjdf.view;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MenuView {
	
	private String pageLink;
	
	public void onNodeSelect(String age) {
		
		 this.setPageLink(age);
	    }

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	
}
