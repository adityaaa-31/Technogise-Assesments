export default function QuantityInput(props) {
  return (
    <>
      <br />
      <input
        className="inputField"
        type="number"
        value={props.quantity}
        onChange={(e) => props.setQuantity(e.target.value)}
        placeholder="Enter it's quantity"
      />
    </>
  );
}
