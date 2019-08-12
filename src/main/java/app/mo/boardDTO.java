package app.mo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "board",schema="mini01")
public class BoardDTO{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int idx;
    @Column
    private String name;
    @Column
    private String pw;
    @Column
    private String title;
    @Column
	private String content;
	
	@Column(
		nullable = false,
		updatable = false
	)
	@CreationTimestamp
	private Date regdate;	

	@Column(
		nullable = false
	)
	@UpdateTimestamp
    private Date modifydate;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
    }
    
	@Override
	public String toString() {
		return "BoardDTO [content=" + content + ", idx=" + idx + ", modifydate=" + modifydate + ", name=" + name
				+ ", pw=" + pw + ", regdate=" + regdate + ", title=" + title + "]";
	}
}