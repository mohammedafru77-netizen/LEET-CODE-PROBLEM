import java.util.HashMap;
import java.util.Map;
class UndergroundSystem {
    private static class CheckInInfo {
        String stationName;
        int time;
        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    private static class RouteInfo {
        double totalTime;
        int count;
        RouteInfo(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
    private final Map<Integer, CheckInInfo> checkInMap;
    private final Map<String, RouteInfo> journeyMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    } 
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.time;
        RouteInfo route = journeyMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.count += 1;
        journeyMap.put(routeKey, route);
    }
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = journeyMap.get(routeKey);
        return route.totalTime / route.count;
    }
}
