package qa.homeWork;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CercTests {

  @Test
  public void testAriaCerc() {
    //Square s = new Square(5);
    Cerc c = new Cerc(5);
    //assert s.ariapatrat()==25;
    //Assert.assertEquals(s.ariapatrat(),25.0);
    Assert.assertEquals(c.AriaCerc(),157.0);
    //pentru aratarea variantei gresite
  }
}
