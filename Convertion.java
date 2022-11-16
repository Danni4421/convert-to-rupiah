import java.util.*;

public class Convertion {
  public static void main(String[] args) {
    // Converter mata uang
    Scanner sc = new Scanner(System.in);
    String[] continent = { "USA", "Eropa", "Asia" };
    String[][] state = {
        { "Canada", "Texas", "Los Angeles" },
        { "United Kingdom", "Amsterdam", "Belgia" },
        { "Japan", "Singapore", "China" }
    };
    String[][] curs = {
        { "Canadians Dolars", "US Dolars", "US Dolars" },
        { "Pound Sterling", "Euro", "Euro" },
        { "Yen", "Dolars Singapore", "Yuan" }
    };
    double[][] valueConvertToIndonesia = {
        { 11675.18, 15535.00, 15535.00 },
        { 18561.22, 16167.27, 16175.04 },
        { 111.61, 11350.19, 2204.95 }
    };
    String cursIndonesia = "Rupiah";
    boolean convertIsTrue = false;

    do {
      System.out.println("Convert Mata Uang");
      System.out.println("Pilih Benua : ");
      showBenua(continent);
      System.out.print("Masukan Benua Pilihan[1/2/3] => ");
      int choosenContinent = sc.nextInt();
      Enter(1);
      showState(choosenContinent, state);
      System.out.println("Pilih Negara");
      System.out.print("Masukan Negara Pilihan[1/2/3] => ");
      int choosenState = sc.nextInt();
      String resultState = checkState(choosenContinent, choosenState, state);
      String cursResult = checkCurs(resultState, state, curs);
      System.out.printf("Masukan besar uang %s : ", cursResult);
      double totalConvert = sc.nextDouble();

      double finalResult = Convert(totalConvert, curs, cursResult, valueConvertToIndonesia);
      System.out.printf("%.2f %s", finalResult, cursIndonesia);

      Enter(1);
      convertIsTrue = checkAgain();
    } while (convertIsTrue);

  }

  private static void showBenua(String[] continent) {
    for (int i = 0; i < continent.length; i++) {
      System.out.printf("%d. %s \n", (i + 1), continent[i]);
    }
  }

  private static void showState(int choosenContinent, String[][] state) {
    int i = 0;
    if (choosenContinent == 1) {
      i = 0;
      for (int j = 0; j < state[0].length; j++) {
        System.out.printf("%d. %s \n", (j + 1), state[i][j]);
      }
    } else if (choosenContinent == 2) {
      i = 1;
      for (int j = 0; j < state[0].length; j++) {
        System.out.printf("%d. %s \n", (j + 1), state[i][j]);
      }
    } else if (choosenContinent == 3) {
      i = 2;
      for (int j = 0; j < state[0].length; j++) {
        System.out.printf("%d. %s \n", (j + 1), state[i][j]);
      }
    }
  }

  private static void Enter(int e) {
    for (int i = 0; i < e; i++) {
      System.out.println("");
    }
  }

  private static String checkState(int choosenContinent, int choosenState, String[][] state) {
    return state[choosenContinent - 1][choosenState - 1];
  }

  private static String checkCurs(String resultState, String[][] state, String[][] curs) {
    String cursResult = "";
    for (int i = 0; i < state.length; i++) {
      for (int j = 0; j < state[0].length; j++) {
        if (state[i][j].equals(resultState)) {
          cursResult = (curs[i][j]);
        }
      }
    }
    return cursResult;
  }

  private static double Convert(double totalConvert, String[][] curs, String cursResult,
      double[][] valueConvertToIndonesia) {
    double hasil = 0;
    double cursValue = 0;
    for (int i = 0; i < curs.length; i++) {
      for (int j = 0; j < curs[0].length; j++) {
        if (cursResult.equals(curs[i][j])) {
          cursValue = valueConvertToIndonesia[i][j];
        }
      }
    }

    hasil = totalConvert * cursValue;

    return hasil;
  }

  private static boolean checkAgain() {
    Scanner sc = new Scanner(System.in);
    Enter(1);
    System.out.println("Apakah Anda ingin melakukan konversi mata uang lagi? ");
    System.out.print("Type y or n => ");
    char confirm = sc.next().charAt(0);
    boolean result = true;
    Enter(1);
    if (confirm == 'y') {
      System.out.println("Silahkan melakukan konversi kembali");
      result = true;
    } else if (confirm == 'n') {
      System.out.println("Terima kasih telah melakukan konversi");
      result = false;
    } else {
      System.out.println("Keyword tidak ditemukan!!");
      result = false;
    }

    return result;
  }
}
