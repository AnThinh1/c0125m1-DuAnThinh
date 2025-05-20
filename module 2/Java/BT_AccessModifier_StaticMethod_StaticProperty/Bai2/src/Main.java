public class Main {
    public static void main(String[] args) {
        UserSession user1 = new UserSession(); // login
        UserSession user2 = new UserSession(); // login
        UserSession user3 = new UserSession(); // login

        System.out.println("Users online: " + UserSession.getOnlineCount()); // 3

        user2.logout(); // user2 logout

        System.out.println("Users online after one logout: " + UserSession.getOnlineCount()); // 2
    }
}
