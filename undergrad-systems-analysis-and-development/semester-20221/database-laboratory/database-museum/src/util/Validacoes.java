package util;

import java.util.InputMismatchException;

public class Validacoes {

    public static boolean validarEmail(String email) {
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    public static boolean validarTelefone(String telefone) {
        telefone = removeCaracteresEspeciais(telefone);

        if (!(telefone.length() >= 10 && telefone.length() <= 11)) return false;

        if (telefone.length() == 11 && Integer.parseInt(telefone.substring(2, 3)) != 9) return false;

        java.util.regex.Pattern p = java.util.regex.Pattern.compile(telefone.charAt(0)+"{"+telefone.length()+"}");
        java.util.regex.Matcher m = p.matcher(telefone);
        if (m.find()) return false;

        Integer[] codigosDDD = {
                11, 12, 13, 14, 15, 16, 17, 18, 19,
                21, 22, 24, 27, 28, 31, 32, 33, 34,
                35, 37, 38, 41, 42, 43, 44, 45, 46,
                47, 48, 49, 51, 53, 54, 55, 61, 62,
                64, 63, 65, 66, 67, 68, 69, 71, 73,
                74, 75, 77, 79, 81, 82, 83, 84, 85,
                86, 87, 88, 89, 91, 92, 93, 94, 95,
                96, 97, 98, 99};

        if (java.util.Arrays.asList(codigosDDD).indexOf(Integer.parseInt(telefone.substring(0, 2))) == -1) return false;


        Integer[] prefixos = {2, 3, 4, 5, 7};

        if (telefone.length() == 10 && java.util.Arrays.asList(prefixos).indexOf(Integer.parseInt(telefone.substring(2, 3))) == -1) return false;

        return true;
    }

    public static boolean validarCNPJ(String CNPJ) {
        CNPJ = removeCaracteresEspeciais(CNPJ);

        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
            (CNPJ.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static boolean validarCPF(String CPF) {

        CPF = removeCaracteresEspeciais(CPF);

        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String removeCaracteresEspeciais(String doc) {
        if (doc.contains("\\D")) {
            doc = doc.replace("\\D", "");
        }
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        if (doc.contains(",")) {
            doc = doc.replace(",", "");
        }
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        if (doc.contains("(")) {
            doc = doc.replace("(", "");
        }
        if (doc.contains(")")) {
            doc = doc.replace(")", "");
        }
        if (doc.contains(" ")) {
            doc = doc.replace(" ", "");
        }
        return doc;
    }

}