package Codice;

import java.util.ArrayList;
import java.util.Random;

public class Giudice {
	public static final int LUNGHEZZA = 4;
	public static final ArrayList<Character> CHARS = new ArrayList<Character>();
	public static final int TENTATIVI = 10;

	private static ArrayList<Tentativo> tentativi = new ArrayList<>();

	static {
		char[] ca = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (Character c : ca) {
			CHARS.add(c);
		}
	}

	public static ArrayList<String> combValide(ArrayList<String> strs) {
        ArrayList<String> result = new ArrayList<String>();

        for (String str : strs) {
            if (ckTargetTnts(str)) {
                result.add(str);
            }
        }

        return result;
    }

	private static boolean ckTargetTnts(String str) {
        for (Tentativo tnt : tentativi) {
            if (numBulls(tnt.getGuess(), str) != tnt.getNumBulls() ||
                numMaggots(tnt.getGuess(), str) != tnt.getNumMaggots()) {
                return false;
            }
        }

        return true;
    }
	public static ArrayList<String> comb(int n, ArrayList<Character> chars) {
        if (n <= 0) {
            return new ArrayList<String>();
        } else {
            ArrayList<String> combinazioni = comb(n - 1, chars);
            ArrayList<String> temp = new ArrayList<String>();
            for (char ch : chars) {
                for (String str : combinazioni) {
                    temp.add(ch + str);
                }
            }
            return temp;
        }
    }


	public static boolean valida(String string) {
		return (string.length() == LUNGHEZZA && caratteriGiusti(string) && caratteriNonRipetuti(string));
	}

	private static boolean caratteriGiusti(String string) {
		for (char c : string.toCharArray()) {
			if (!CHARS.contains(c))
				return false;
		}
		return true;
	}

	private static boolean caratteriNonRipetuti(String string) {
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length - 1; i++) {
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j])
					return false;
			}
		}
		return true;
	}

	public static int numBulls(String string, String string2) {
		char[] c = string.toCharArray();
		char[] c2 = string2.toCharArray();
		int bull = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == c2[i])
				bull++;
		}
		return bull;
	}

	public static int numMaggots(String string, String string2) {
		int maggot = 0;
		char[] c = string.toCharArray();
		char[] c2 = string2.toCharArray();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c[i] == c2[j] && i != j)
					maggot++;
			}
		}
		return maggot;
	}

	public static String genTarget() {
		Random random = new Random();
		int index = 0, maxNumber = (int) Math.pow(10, LUNGHEZZA) - 1;
		do {
			index = random.nextInt(maxNumber);
		} while (!valida(String.valueOf(index)));
		return String.valueOf(index);
	}

	
}
