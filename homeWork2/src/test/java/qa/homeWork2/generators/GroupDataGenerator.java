package qa.homeWork2.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names="-c", description = "Group count")
  public int count;

  @Parameter(names="-f", description = "Target file")
  public String file;


  public static void main(String[] args) throws IOException {

    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    save(groups, new File(file));
  }

  private void save(List<GroupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s; %s; %s\n", group.name(), group.header(),
              group.footer()));
    }
    writer.close();
  }

  private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withName(String.format("TestNewGroupName %s", i))
              .withHeader(String.format("TestHeader %s", i))
              .withFooter(String.format("TestFooter %s", i)));
    }
    return groups;
  }
}
