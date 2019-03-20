package github.incodelearning.basics;

import java.util.*;
import java.util.stream.Collectors;

public class DemoHashMap {

    static class Farm {
        String name;
        String crop;
        int size;

        public Farm(String name, String crop, int size) {
            this.name = name;
            this.crop = crop;
            this.size = size;
        }

        @Override
        public String toString() {
            return String.format("Farm[name:%s, crop:%s, size:%s]", name, crop, size);
        }
    }

    public static Map<String, List<Farm>> top2FarmsForEachCrop(List<Farm> farms) {
        Map<String, List<Farm>> farmsByCrop = new HashMap<String, List<Farm>>();
        for(Farm farm:farms) {
            String crop = farm.crop;
            if (farmsByCrop.containsKey(crop)) {
                farmsByCrop.get(crop).add(farm);
            } else {
                ArrayList<Farm> farmList = new ArrayList<>();
                farmList.add(farm);
                farmsByCrop.put(crop,farmList);
            }
        }

        Map<String, List<Farm>> top2FarmsForEachCrop = new HashMap<>();
        for(Map.Entry<String, List<Farm>> entry : farmsByCrop.entrySet()) {
            String crop = entry.getKey();
            List<Farm> curFarms = entry.getValue();
            Collections.sort(curFarms, Comparator.comparingInt(farm -> farm.size));
            Collections.reverse(curFarms);
            List<Farm> top2Farms = curFarms.stream().limit(2).collect(Collectors.toList());
            top2FarmsForEachCrop.put(crop, top2Farms);
        }

        return top2FarmsForEachCrop;
    }

    public static void main(String[] args) {

        // Given a list of farms with attributes “name”, “crop”, and “size”, return a list of the top two farms by size for each crop.

        List<Farm> farms = new ArrayList<>();
        farms.add(new Farm("adams", "corn", 100));
        farms.add(new Farm("adair", "soybeans", 50));
        farms.add(new Farm("benton", "soybeans", 90));
        farms.add(new Farm("carroll", "wheat", 200));
        farms.add(new Farm("creation", "corn", 90));
        farms.add(new Farm("dansplot" , "soybeans", 55));
        farms.add(new Farm("edgars", "soybeans", 95));
        farms.add(new Farm("everlast", "corn", 70));
        farms.add(new Farm("greenacres", "wheat", 205));
        farms.add(new Farm("greenacres", "cucumber", 205));



        System.out.println(top2FarmsForEachCrop(farms));

        Map<String, String> map = new HashMap<>();
        map.put("1", "test1");
        map.put("2", "test2");

        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
