Campsite Commander
Android Camping Packing List Application

 Purpose
 
Campsite Commander is a simple mobile application designed to help campers organize and track their camping gear. The app ensures users do not forget essential items for their trip, making packing easier and less stressful.

 Features
- **Dashboard:** Displays total number of items added
- **Add New Gear:** Input item name, select category, set quantity, and add optional notes
- **Category Organization:** Items grouped by type: Shelter, Cooking, Food, First Aid, Safety, Clothing, Tools, Lighting
- **Full List View:** Shows complete details of all added items
- **User-Friendly Design:** Dark green nature-themed interface with clear navig

Technology Used
- **Platform:** Android
- **Development Environment:** Android Studio
- **Programming Language:** Kotlin
- **UI Design:** XML
- **Data Management:** Parcelable interface for transferring objects between screens
- **Minimum SDK:** Android 8.0 (API 26)


**A Pseudocode**

// DATA MODEL

CLASS GearItem

    PROPERTIES:
        itemName: String
        category: String
        quantity: Integer
        comment: String
END CLASS

// MAIN SCREEN
PROCEDURE MainActivity
    INITIALIZE empty list of GearItem
    ADD sample items to list on startup
    DISPLAY total number of items

    ON "Add New Gear" button click:
        OPEN Add Gear screen
        WAIT for result

    ON "View Full List" button click:
        SEND list to Detailed List screen
        OPEN Detailed List screen

    ON receiving new item from Add Gear screen:
        ADD item to list
        UPDATE total item count display
END PROCEDURE

// ADD GEAR SCREEN
PROCEDURE AddGearActivity
    DISPLAY input form: name, category, quantity, notes

    ON "Save" button click:
        READ input values
        VALIDATE: name not empty, quantity is positive number
        IF invalid: SHOW error message
        ELSE:
            CREATE new GearItem object
            RETURN item to Main screen
            CLOSE screen
END PROCEDURE

// DETAILED LIST SCREEN
PROCEDURE DetailedListActivity
    RECEIVE list of GearItem
    BUILD formatted text showing all item details
    DISPLAY full list
END PROCEDURE

##  App Screenshots

### Main Screen
![main screen](https://github.com/chantie389/campsiteCommander/blob/8ca5edc571a67b4ccbf4cc16c06e19c872c72c36/main%20activity.jpeg)

### Gear Screen
![gear screen](https://github.com/chantie389/campsiteCommander/blob/91ae0e784faa78eb345fec227795b121a5a365b4/gear%20activity.jpeg)

### Data class Screen
![data class screen](https://github.com/chantie389/campsiteCommander/blob/fa8f142db4435caeedc7e8a4439162783f97d46a/data%20class%20.jpeg)

### Splash Screen
![splash screen](https://github.com/chantie389/campsiteCommander/blob/c38577b8b2adde760aea442a77b587e13b1e05e0/splash%20activity.jpeg)


 
