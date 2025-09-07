# ShopEase: JavaFX Shop Management System

A straightforward desktop Point of Sale (POS) application built with JavaFX. **ShopEase** provides a simple, clean interface for a cashier to manage daily sales, process payments, and generate receipts for a small retail or grocery store.

> **Note:** Replace this with an actual screenshot of your application's dashboard.

---

## Core Features

- **Simple Authentication:** Basic login screen to secure access to the main sales dashboard.  
- **Visual POS Dashboard:** Intuitive grid of product cards with image, price, and quantity selector.  
- **Dynamic Cart:** Live-updating table view of items in the current transaction.  
- **Automatic Calculations:** Calculates total price and change instantly.  
- **Easy Cart Management:** Remove items from the cart with a single click.  
- **Receipt Generation:** Creates uniquely timestamped `.txt` receipts for each transaction.  
- **Secure Sign-Out:** Confirmation prompt before ending the session.

---

## How It Works

### Login
The app starts with a login window. Hardcoded credentials:


### Dashboard
After login, the main dashboard appears with two sections:

- **Left Side (Products):** Scrollable product list. Use quantity spinner and click "ADD" to add items to the cart.  
- **Right Side (Cart & Payment):** Transaction hub. Shows items, Total, Amount, and Change.

### Making a Sale
1. Add items to the cart – total updates in real-time.  
2. Enter amount received – change calculated instantly.  
3. Finalize the transaction:  
   - **RECEIPT:** Generates `.txt` file with transaction details and opens it.  
   - **PAY:** Displays "Thank You" message and resets dashboard for the next customer.

---

## Technologies Used

- **Core:** Java  
- **UI Framework:** JavaFX  
- **UI Definition:** FXML  
- **Styling:** CSS  
- **Build Tool:** Apache Ant (within NetBeans)  
- **IDE:** NetBeans  

---

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK) 21 or compatible  
- Apache NetBeans IDE  

### Instructions
1. **Clone the repository:**
   ```bash
   git clone https://github.com/AlMamun09/Shop-Management-System.git
