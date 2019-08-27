package app.model.comment;

import java.util.List;

/**
 * page
 */
public class CommentPage {

    private List<CommentModel> list;
    private int maxpage;
    private int currpage;
    private int size;

    public List<CommentModel> getList() {
        return list;
    }

    public void setList(List<CommentModel> list) {
        this.list = list;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(int maxpage) {
        this.maxpage = maxpage;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}