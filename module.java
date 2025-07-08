import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String Nom_Du_Produit;
        int montant;
        int quantite;
        int prix_total;
        double TVA;
        double prix_taux_TVA;
        double TVA_2;
        double prix_taux_TVA2;
        int choix;


        System.out.print("\n\n" +
                "Enter the name of product ");
        Nom_Du_Produit= sc.nextLine();

        System.out.print("Enter the price  of product : ");
        montant= sc.nextInt();

        System.out.print("Enter the quantity  of product  : ");
        quantite= sc.nextInt();

        System.out.print("Enter the rate   TVA en % : ");
        TVA = sc.nextDouble();

        prix_total= montant*quantite;

        prix_taux_TVA= ((prix_total*TVA)/100);


        //Au cas vous souhaiterez ajouter d'autres taux ou taxes
        do {
            System.out.print(" \n do you want to add more  taxes ? \n if yes  enter 1 \n if no enter 0 \n Entrer your choice : ");
            choix= sc.nextInt();
        } while (choix!=0 && choix!=1);

        switch (choix) {
            case (0):

                //Confirmation de vente

                do {
                    System.out.println("type 1  to confirm  the sale or  O for cancel");
                    choix = sc.nextInt();
                } while (choix!=0 && choix!=1);

                switch (choix) {
                    case 0:
                        System.out.println("Sale cancel...");


                        break;

                    //FACTURE

                    case 1 :
                        System.out.println(" PHARMACY* BILLS");
                        System.out.println("\t"+ "Products : " + Nom_Du_Produit);
                        System.out.println("\t"+ "Unit price  : " + montant + " FCFA" );
                        System.out.println("\t"+ "Quantity : " + quantite );
                        System.out.println("\t"+ " brut Amount: " + prix_total + " FCFA");
                        System.out.println("\t"+ "rate of TVA: " + TVA + " %");
                        System.out.println("\t"+ "secondary rate : 0 %");
                        System.out.println("\t"+ "the amount of TVA:" +prix_taux_TVA+ " FCFA ");
                        System.out.println("\t"+ "the amount of  secondary rate : 0 FCFA  \n");
                        System.out.println("total Amount TTC : " + (prix_total+prix_taux_TVA) + " FCFA");

                        break;
                }


                break;


            case (1):
                System.out.print("\n Enter the others  rate in  %: ");
                TVA_2= sc.nextDouble();

                prix_taux_TVA2= ((prix_total*TVA_2)/100);

                //Confirmation de vente
                do {
                    System.out.println(" Appuyer 1 confirmer la vente ou O pour Annuler");
                    choix = sc.nextInt();
                } while (choix!=0 && choix!=1);

                switch (choix) {
                    case 0:
                        System.out.println("Vente Annuler...");

                        break;

                    case 1 :


                        // FACTURE

                        System.out.println("\n \n  ****FACTURE DE PHARMACIE***** \n");
                        System.out.println("\t"+ "Produits : " + Nom_Du_Produit);
                        System.out.println("\t"+ "Prix unitaire : " + montant + " FCFA");
                        System.out.println("\t"+ "Quantité : " + quantite );
                        System.out.println("\t"+ "Montant brut: " + prix_total + " FCFA");
                        System.out.println("\t"+ "Taux de la TVA: " + TVA + " %");
                        System.out.println("\t"+ "Taux secondaire: " + TVA_2 + " %");
                        System.out.println("\t"+ "Le montant de la TVA: " + prix_taux_TVA + " FCFA");
                        System.out.println("\t"+ "Le montant taux secondaire : " + prix_taux_TVA2 + " FCFA  \n");
                        System.out.println("Montant total TTC : " + (prix_total+prix_taux_TVA+prix_taux_TVA2) + " FCFA");

                        break;
                }

                break;
}

}

}
