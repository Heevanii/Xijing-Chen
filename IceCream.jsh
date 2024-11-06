void iceCreamShop(String studentNumber) {
    String lastSix = studentNumber.substring(studentNumber.length() - 6);
    
    int vanillaPrice = Integer.parseInt(lastSix.substring(4, 6)); // Last 2 digits for vanilla
    int chocolatePrice = Integer.parseInt(lastSix.substring(2, 4)); // Middle 2 digits for chocolate
    int strawberryPrice = Integer.parseInt(lastSix.substring(0, 2)); // First 2 digits for strawberry

    System.out.println("Would you like (v)anilla, (c)hocolate or (s)trawberry?");
    String flavourChoice = System.console().readLine().toLowerCase();

    if (!(flavourChoice.equals("v") || flavourChoice.equals("c") || flavourChoice.equals("s"))) {
        System.out.println("We don't have that flavour.");
        return;
    }

    System.out.println("How many scoops would you like?");
    int numScoops;
    
    try {
        numScoops = Integer.parseInt(System.console().readLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid number of scoops.");
        return;
    }

    if (numScoops < 1) {
        System.out.println("We don't sell just a cone.");
        return;
    } else if (numScoops > 3) {
        System.out.println("That's too many scoops to fit in a cone.");
        return;
    }

    int pricePerScoop = 0;
    switch (flavourChoice) {
        case "v":
            pricePerScoop = vanillaPrice;
            break;
        case "c":
            pricePerScoop = chocolatePrice;
            break;
        case "s":
            pricePerScoop = strawberryPrice;
            break;
    }

    int totalCostInPence = 100 + (pricePerScoop * numScoops);
    int pounds = totalCostInPence / 100;
    int pence = totalCostInPence % 100;
    
    System.out.println("That will be " + pounds + "." + (pence < 10 ? "0" + pence : pence) + " please.");
}
