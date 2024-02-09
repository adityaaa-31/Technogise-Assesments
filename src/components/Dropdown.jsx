import ItemList from "./ItemList.jsx";

export default function Dropdown({ items, selectedItem, setSelectedItem }) {
  return (
    <select
      value={selectedItem}
      onChange={(e) => setSelectedItem(e.target.value)}
    >
      <ItemList items={items} />
    </select>
  );
}
