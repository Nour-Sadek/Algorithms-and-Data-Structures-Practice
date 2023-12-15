package leetcode.easy;

import java.util.*;

/*

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 */

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> source = new HashSet<String>();
        Set<String> destination = new HashSet<String>();

        for (List<String> path: paths) {
            source.add(path.get(0));
            destination.add(path.get(1));
        }

        destination.removeAll(source);

        Optional<String> output = destination.stream().findFirst();

        String finalDestination = "";
        if (output.isPresent()) {
            finalDestination = output.get();
        }

        return finalDestination;
    }
}

