function Cart(props) {
  return (
    <tr>
      <td>{props.id}</td>
      <td>{props.product}</td>
      <td>{props.price}</td>
      <td>{props.quantity}</td>
    </tr>
  );
}

export default Cart;