package Controller;

import Data.*;
import Exceptions.IncorrectValueException;
import Exceptions.NotEmptyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AskManager implements IAskManager {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String askName() {
        String name = null;
        try {
            System.out.print("Enter name: ");
            name = reader.readLine().trim();
            if (name.equals("")) throw new NotEmptyException();
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askName();
        }
        catch (NullPointerException e){
            System.out.println("Name can not be Null");
            return askName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public Coordinates askCoordinates() {
        Coordinates coordinates;
        System.out.println("Enter coordinates: ");
        coordinates = new Coordinates(askCoordinateX(), askCoordinateY());
        return coordinates;
    }

    @Override
    public Long askCoordinateX() {
        String strX;
        Long x = null;
        try {
            System.out.print("x = ");
            strX = reader.readLine().trim();
            if (strX.equals("")) throw new NotEmptyException();
            if (Long.parseLong(strX) <= -893) throw new IncorrectValueException();
            x = Long.parseLong(strX);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateX();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateX();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public Integer askCoordinateY() {
        String strY = null;
        Integer y = null;
        try {
            System.out.print("y = ");
            strY = reader.readLine().trim();
            if (strY.equals("")) throw new NotEmptyException();
            if (Integer.parseInt(strY) <= -893) throw new IncorrectValueException();
            y = Integer.parseInt(strY);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateY();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateY();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return y;
    }

    @Override
    public Integer askHeight() {
        String strHeight;
        Integer height = null;
        try {
            System.out.print("Enter height: ");
            strHeight = reader.readLine().trim();
            if (strHeight.equals("")) throw new NotEmptyException();
            if (Integer.parseInt(strHeight) <= 0) throw new IncorrectValueException();
            height = Integer.parseInt(strHeight);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askHeight();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askHeight();
        }
        catch (IncorrectValueException e){
            System.out.println("Value must be more than zero");
            return askHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return height;
    }

    public Color askColor() throws IOException {
        Color color;
        String strColor;
        try {
            System.out.print("Enter hair color: ");
            strColor = reader.readLine().trim().toUpperCase();
            if (strColor.equals("")) throw new NotEmptyException();
            color = Color.valueOf(strColor);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askColor();
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
            return askColor();
        }
        return color;
    }

    public Country askCountry() throws IOException {
        Country country;
        String strCountry;
        try {
            System.out.print("Enter country: ");
            strCountry = reader.readLine().trim().toUpperCase();
            if (strCountry.equals("")) throw new NotEmptyException();
            country = Country.valueOf(strCountry);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askCountry();
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
            return askCountry();
        }
        return country;
    }

    public Location askLocation() {
        Location location;
        System.out.println("Enter location: ");
        location = new Location(askCoordinateX(), askCoordinateY(), askLocationName());
        return location;
    }

    public Long askLocationX() {
        String strX;
        Long x = null;
        try {
            System.out.print("x = ");
            strX = reader.readLine().trim();
            if (strX.equals("")) throw new NotEmptyException();
            if (Long.parseLong(strX) <= -893) throw new IncorrectValueException();
            x = Long.parseLong(strX);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateX();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateX();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }

    public double askLocationY() {
        String strY = null;
        double y = 0;
        try {
            System.out.print("y = ");
            strY = reader.readLine().trim();
            if (strY.equals("")) throw new NotEmptyException();
            if (Double.parseDouble(strY) <= -893) throw new IncorrectValueException();
            y = Double.parseDouble(strY);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateY();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateY();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return y;
    }

    public String askLocationName() {
        String name = null;
        try {
            System.out.print("Enter location name: ");
            name = reader.readLine().trim();
            if (name.equals("")) throw new NotEmptyException();
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askName();
        }
        catch (NullPointerException e){
            System.out.println("Location name can not be Null");
            return askName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
