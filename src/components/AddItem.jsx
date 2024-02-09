export default function AddItemButton({ itemList, setItemList, selectedItem }) {
  return (
    <>
      <div>
        <button
          className="selectItemButton"
          onClick={() => setItemList([...itemList, selectedItem])}
        >
          Add Item
        </button>
      </div>

      <ul></ul>
    </>
  );
}
