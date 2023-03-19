package co2.impact.co2impact;

/**
 * Auteur : Alvin KITA
 * Version : 0.3
**/

import java.util.Scanner;
import java.text.DecimalFormat; // Servira à ne pas avoir une dizaine de décimales après la vilgule

import org.geotools.geometry.DirectPosition2D;
import org.geotools.referencing.GeodeticCalculator;
import org.opengis.referencing.operation.TransformException;

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        // Déclaration des variables de position
        double xPosFrom = 0;
        double yPosFrom = 0;
        double xPosTo = 0;
        double yPosTo = 0;
        
        // Déclaration des variables de consomation du véhicule
        double consommationCarburant = 0.3;     // En litres pour 1km
        double FacteurEmmissionsCo2 = 2.6;        // En Kg/L

        // Déclaration des coordonnée des localisations
        double xParedesGenas = 45.715422;
        double yParedesGenas = 4.994829;

        double xParedesStQuentinFallavier = 45.653394;
        double yParedesStQuentinFallavier = 5.115961;

        double xParedesRennes = 48.075672;
        double yParedesRennes = -1.733396;

        double xParedesMarseille = 43.486335;
        double yParedesMarseille = 5.622602;

        double xParedesMulhouse = 47.877181;
        double yParedesMulhouse = 7.354527;

        double xParedesGousainville = 49.020737;
        double yParedesGousainville = 2.461474;

        double xParedesToulouse = 43.645299;
        double yParedesToulouse = 1.337252;
        
        // Autres déclarations
        String nomFrom = "";    // Ces deux Strings me servirons pour stocker et afficher les noms des lieux choisis
        String nomTo = "";


        // C'est parti !!
        System.out.println("Bonjour.");
        System.out.println("Veuillez saisir le numéro du point de départ (0 pour afficher la liste):");
        
        // Saisie et vérification du point de départ
        int choixFrom = -1;
        boolean choixPossible = false;
        while (choixPossible != true )
        {
            choixFrom = input.nextInt();
            if (choixFrom == 0)
            {
                System.out.println("1 -> Paredes Genas");
                System.out.println("2 -> Paredes St Quentin Fallavier");
                System.out.println("3 -> Paredes Rennes");
                System.out.println("4 -> Paredes Marseille");
                System.out.println("5 -> Paredes Mulhouse");
                System.out.println("6 -> Paredes Gousainville");
                System.out.println("7 -> Paredes Toulouse");
            }
            else if (choixFrom == 1) // Genas
            {
                xPosFrom = xParedesGenas;
                yPosFrom = yParedesGenas;
                nomFrom = "Paredes Genas";
                choixPossible = true;
            }
            else if (choixFrom == 2) // St Quentin Fallavier
            {
                xPosFrom = xParedesStQuentinFallavier;
                yPosFrom = yParedesStQuentinFallavier;
                nomFrom = "Paredes St Quentin Fallavier";
                choixPossible = true;
            }
            else if (choixFrom == 3) // Rennes
            {
                xPosFrom = xParedesRennes;
                yPosFrom = yParedesRennes;
                nomFrom = "Paredes Rennes";
                choixPossible = true;
            }
            else if (choixFrom == 4) // Marseille
            {
                xPosFrom = xParedesMarseille;
                yPosFrom = yParedesMarseille;
                nomFrom = "Paredes Marseille";
                choixPossible = true;
            }
            else if (choixFrom == 5) // Mulhouse
            {
                xPosFrom = xParedesMulhouse;
                yPosFrom = yParedesMulhouse;
                nomFrom = "Paredes Mulhouse";
                choixPossible = true;
            }
            else if (choixFrom == 6) // Gousainville
            {
                xPosFrom = xParedesGousainville;
                yPosFrom = yParedesGousainville;
                nomFrom = "Paredes Gousainville";
                choixPossible = true;
            }
            else if (choixFrom == 7) // Toulouse
            {
                xPosFrom = xParedesToulouse;
                yPosFrom = yParedesToulouse;
                nomFrom = "Paredes Toulouse";
                choixPossible = true;
            }

            else 
            {
                System.out.println("Choix inconnu...");
                System.out.println();
                System.out.println("Veuillez saisir le numéro du point de départ (0 pour afficher la liste):");
            }


        }
        System.out.println("Vous avez choisi comme point de départ : " + nomFrom);
        System.out.println();
        System.out.println("Veuillez saisir le numéro du point d'arrivée (0 pour afficher la liste):");
        
        // Saisie et vérification du point d'arrivée
        int choixTo = -1;
        choixPossible = false;
        while (choixPossible != true )
        {
            choixTo = input.nextInt();
            if (choixTo == 0)
            {
                System.out.println("1 -> Paredes Genas");
                System.out.println("2 -> Paredes St Quentin Fallavier");
                System.out.println("3 -> Paredes Rennes");
                System.out.println("4 -> Paredes Marseille");
                System.out.println("5 -> Paredes Mulhouse");
                System.out.println("6 -> Paredes Gousainville");
                System.out.println("7 -> Paredes Toulouse");
            }
            else if (choixTo == 1) // Genas
            {
                xPosTo = xParedesGenas;
                yPosTo = yParedesGenas;
                nomTo = "Paredes Genas";
                choixPossible = true;
            }
            else if (choixTo == 2) // St Quentin Fallavier
            {
                xPosTo = xParedesStQuentinFallavier;
                yPosTo = yParedesStQuentinFallavier;
                nomTo = "Paredes St Quentin Fallavier";
                choixPossible = true;
            }
            else if (choixTo == 3) // Rennes
            {
                xPosTo = xParedesRennes;
                yPosTo = yParedesRennes;
                nomTo = "Paredes Rennes";
                choixPossible = true;
            }
            else if (choixTo == 4) //Marseille
            {
                xPosTo = xParedesMarseille;
                yPosTo = yParedesMarseille;
                nomTo = "Paredes Marseille";
                choixPossible = true;
            }
            else if (choixTo == 5) //Mulhouse
            {
                xPosTo = xParedesMulhouse;
                yPosTo = yParedesMulhouse;
                nomTo = "Paredes Mulhouse";
                choixPossible = true;
            }
            else if (choixTo == 6) // Gousainville
            {
                xPosTo = xParedesGousainville;
                yPosTo = yParedesGousainville;
                nomTo = "Paredes Gousainville";
                choixPossible = true;
            }
            else if (choixTo == 7) // Toulouse
            {
                xPosTo = xParedesToulouse;
                yPosTo = yParedesToulouse;
                nomTo = "Paredes Toulouse";
                choixPossible = true;
            }
            else 
            {
                System.out.println("Choix inconnu...");
                System.out.println("Veuillez saisir le numéro du point d'arrivée (0 pour afficher la liste):");
            }


        }
        System.out.println("Vous avez choisi comme point de d'arrivée : " + nomTo);
        System.out.println();

        // Les points de départ et d'arrivée
        DirectPosition2D from = new DirectPosition2D(xPosFrom, yPosFrom); // La maison
        DirectPosition2D to = new DirectPosition2D(xPosTo, yPosTo); // Paredes Genas

        // Créer un GeodeticCalculator pour calculer la distance
        GeodeticCalculator gc = new GeodeticCalculator();

        // Le calcul, sans le <try / catch> ça ne marche pas
        try {
            gc.setStartingPosition(from);
            gc.setDestinationPosition(to);
            double distance = (gc.getOrthodromicDistance()/1000);
            DecimalFormat df = new DecimalFormat("#.###");
            distance = Double.parseDouble(df.format(distance));
            double quantitéCarburant = consommationCarburant * distance;
            double emmissionsCo2 = quantitéCarburant * FacteurEmmissionsCo2;
            emmissionsCo2 = Double.parseDouble(df.format(emmissionsCo2));
            System.out.println("Longeur du trajet moyen en km de " + nomFrom + " à " + nomTo + " est de : " + distance + "km");
            System.out.println("Les emmissions de Co2 du trajet sont de " + emmissionsCo2 + " kg de Co2.");
        } catch (TransformException e) {
            System.out.println("Erreur de transformation de coordonnées : " + e.getMessage());
        }
    }
}
