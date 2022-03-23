package qa.homeWork;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CercTests {

  @Test
  public void testAriaCerc() {

    Cerc c = new Cerc(5);
    Assert.assertEquals(c.AriaCerc(),157.0);

  }
}
