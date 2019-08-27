/**
 * 
 */

package percy.mybatis.zetcode.book;

/**
 * Book
 */
public class Book {

  private Long id;
  private String author;
  private String title;
  private int published;
  private String remark;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPublished() {
    return published;
  }

  public void setPublished(int published) {
    this.published = published;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "Book [author=" + author + ", id=" + id + ", published=" + published + ", remark=" + remark + ", title="
        + title + "]";
  }
}