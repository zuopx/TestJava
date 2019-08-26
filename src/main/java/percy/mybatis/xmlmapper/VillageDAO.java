/**
 * Creating interface for CRUD operation.
 */

package percy.mybatis.xmlmapper;

/**
 * VillageDAO
 */
public interface VillageDAO {

  public void insert(Village village);

  public void update(Village village);

  public void delete(Integer id);

  public Village select(Integer id);
}