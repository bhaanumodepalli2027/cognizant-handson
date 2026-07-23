import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  function increment() {
    setCount(count + 1);
  }

  function decrement() {
    setCount(count - 1);
  }

  function sayHello() {
    alert("Hello! Welcome to Cognizant Digital Nurture.");
  }

  function sayWelcome(message) {
    alert(message);
  }

  function handleClick() {
    alert("I was clicked");
  }

  function increaseAndHello() {
    increment();
    sayHello();
  }

  return (
    <div style={{ textAlign: "center", marginTop: "40px" }}>
      <h1>Event Examples</h1>

      <h2>Counter : {count}</h2>

      <button onClick={increaseAndHello}>Increment</button>

      <button onClick={decrement} style={{ marginLeft: "10px" }}>
        Decrement
      </button>

      <br /><br />

      <button onClick={() => sayWelcome("Welcome to React Event Handling")}>
        Say Welcome
      </button>

      <br /><br />

      <button onClick={handleClick}>
        Synthetic Event
      </button>
    </div>
  );
}

export default App;