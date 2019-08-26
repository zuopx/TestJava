/**
 * https://www.concretepage.com/mybatis-3/getting-started-with-mybatis-3-crud-operations-example-with-xml-mapper
 */

package percy.mybatis.xmlmapper;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    VillageTemplate villageTemplate = new VillageTemplate();

    // insert
    Village village = new Village();
    village.setName("Crossing Republic");
    village.setDistrict("Ghaziabad");
    villageTemplate.insert(village);
    System.out.println("Done, insert.");
    
    // update
    village = new Village();
	  village.setId(1);
	  village.setName("Dhananjaypur");
	  village.setDistrict("Varanasi");
    villageTemplate.update(village);
    System.out.println("Done, update.");

    // select
    village = villageTemplate.select(1);
    System.out.println(village);
    System.out.println("Done, select.");

    // delete
    villageTemplate.delete(1);
    System.out.println("Done, delete.");

    System.out.println("Done!");
  }
}