import java.util.ArrayList;
import java.util.List;

public class LeetCode841 {
    //841. Keys and Rooms

    static boolean[] visited;
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited=new boolean[rooms.size()];
        visited[0]=true;
        helperDFS(rooms,0);

        for(boolean room:visited){
            if(!room)
                return false;
        }
        return true;
    }

    static void helperDFS(List<List<Integer>> rooms,int index){
        for(int room: rooms.get(index)) {
//            System.out.println("room:"+room+" "+"index:"+index); //debugging
            if (!visited[room]) {
                visited[room] = true;
                helperDFS(rooms, room);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1, 3));
        rooms.add(List.of(3,0,1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));

        canVisitAllRooms(rooms);

    }

}


//T.C - O(room+keys)
//S.C - O(rooms.size) // for visited array