/**
 * POJO class Village.
 */

package percy.mybatis.xmlmapper;

/**
 * Village
 */
public class Village {

  private Integer id;
  private String name;
  private String district;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  @Override
  public String toString() {
    return "Village [district=" + district + ", id=" + id + ", name=" + name + "]";
  }
}