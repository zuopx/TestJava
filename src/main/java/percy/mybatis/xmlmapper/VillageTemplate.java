/**
 * Create methods for CRUD operation. Mybatis provides different API to handle it.
 */

package percy.mybatis.xmlmapper;

import org.apache.ibatis.session.SqlSession;

/**
 * VillageTemplate
 */
public class VillageTemplate implements VillageDAO{

  @Override
  public void insert(Village village) {
    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
    session.insert("percy.mybatis.xmlmapper.VillageMapper.insertVillage", village);
    session.commit();
    session.close();
  }

  @Override
  public void update(Village village) {
    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
    session.update("percy.mybatis.xmlmapper.VillageMapper.updateVillage", village);
    session.commit();
    session.close();
  }

  @Override
  public void delete(Integer id) {
    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
    session.delete("percy.mybatis.xmlmapper.VillageMapper.deleteVillage", id);
    session.commit();
    session.close();
  }

  @Override
  public Village select(Integer id) {
    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
    Village village = session.selectOne("percy.mybatis.xmlmapper.VillageMapper.selectVillage", id);
    session.close();
    return village;
  }
}