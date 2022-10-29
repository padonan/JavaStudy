public class Solution {
    public static void solution(String[] idPw, String[][] db) {
        int i,j;

        if(idPw.length == 2) {
            String stringIdPw = idPw[0] + idPw[1];
            System.out.println(stringIdPw);

        for(i=0; i < db.length; i++) {
            for (j = 0; j < db.length; j++) {
                String DbString = db[i][j];
                if (DbString.equals(stringIdPw)) {
                    System.out.println("login");
                    return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] idPw = {"123", "123"};
        String[][] db = {{"123","123"},{"123","123"}};
        Solution.solution(idPw,db);
    }
}
