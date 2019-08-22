package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CommentM
 */
@Entity
@Table(name = "comment", schema = "mini01")
public class CommentModel {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idx; // 기본키
    @Column
    private int user_idx;
    @Column
    private int bbs_idx;
    @Column
    private String name;
    @Column
    private String content;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public int getBbs_idx() {
        return bbs_idx;
    }

    public void setBbs_idx(int bbs_idx) {
        this.bbs_idx = bbs_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentM [Bbs_idx=" + bbs_idx + ", content=" + content + ", idx=" + idx + ", name=" + name
                + ", user_idx=" + user_idx + "]";
    }
}