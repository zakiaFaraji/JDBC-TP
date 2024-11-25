public class Acces {
    private int id;
    private String prenom;
    private String login;
    private String password;
    private String statut;
    private int age;

    // Constructeur par défaut
    public Acces() {
    }

    // Constructeur avec tous les attributs
    public Acces(int id, String prenom, String login, String password, String statut, int age) {
        this.id = id;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.statut = statut;
        this.age = age;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Acces{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", statut='" + statut + '\'' +
                ", age=" + age +
                '}';
    }
}
