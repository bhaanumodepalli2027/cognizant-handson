import Cart from "./Cart";
import "../Stylesheets/shopping.css";

function OnlineShopping() {
  return (
    <div className="container">
      <h1>Online Shopping Cart</h1>

      <table>
        <thead>
          <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price (₹)</th>
            <th>Quantity</th>
          </tr>
        </thead>

        <tbody>
          <Cart id="101" product="Laptop" price="65000" quantity="1" />
          <Cart id="102" product="Keyboard" price="1500" quantity="2" />
          <Cart id="103" product="Mouse" price="800" quantity="1" />
          <Cart id="104" product="Headphones" price="2500" quantity="1" />
        </tbody>
      </table>
    </div>
  );
}

export default OnlineShopping;