package qa.homeWork2.generators;

import qa.homeWork2.model.GroupData;
import qa.homeWork2.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<GroupData> groups = generateGroups(count);
    save(groups, file);

  }

  private static void save(List<GroupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s; %s; %s\n", group.name(), group.header(),
              group.footer()));
    }
    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withName(String.format("TestNewGroupName %s", i))
              .withHeader(String.format("TestHeader %s", i))
              .withFooter(String.format("TestFooter %s", i)));
    }
    return groups;
  }
}
