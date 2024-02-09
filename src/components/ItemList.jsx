function ItemList({ items }) {
  return (
    <>
      {items.map((item, index) => (
        <option key={index}>{item.name}</option>
      ))}
    </>
  );
}

export default ItemList;
