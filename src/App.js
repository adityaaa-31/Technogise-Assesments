import "./App.css";
import { useState } from "react";
import Dropdown from "./components/Dropdown";
import QuantityInput from "./components/Quantity";
import CalculateGSTButton from "./components/CalculateButton";
import SelecItemButton from "./components/AddItem";
import AddItemButton from "./components/AddItem";

function App() {
  const [finalPrice, setFinalPrice] = useState(0);
  const [quantity, setQuantity] = useState(0);
  const [selectedItem, setSelectedItem] = useState("");
  const [itemList, setItemList] = useState([]);

  const categories = {
    //1
    laptop: {
      category: "Electronics",
      gst: 18,
    },

    //2
    Food: {
      types: [{}, {}],
      gst: 8,
    },

    Stationary: {
      types: [
        {
          name: "book",
          gst: 3,
          price: 100,
        },
        ,
        {},
      ],
      gst: 6,
    },
  };

  const items = [
    {
      name: "book",
      gst: 3,
      price: 100,
    },
    {
      name: "laptop",
      gst: 18,
      price: 200,
    },
    {
      name: "sofa",
      gst: 10,
      price: 150,
    },
  ];

  let final_price = 0;

  function calulateGST() {
    let gst_price = 0;
    let gst_rate = 0;

    for (let i = 0; i < items.length; i++) {
      if (items[i].name === selectedItem) {
        gst_rate = items[i].gst / 100;
        gst_price = items[i].price + items[i].price * gst_rate;
      }
    }

    final_price = quantity * gst_price;

    setFinalPrice(quantity * gst_price);

    console.log(final_price);
  }

  return (
    <div className="App">
      <Dropdown
        items={items}
        selectedItem={selectedItem}
        setSelectedItem={setSelectedItem}
      />
      <br></br>
      <QuantityInput quantity={quantity} setQuantity={setQuantity} />

      <AddItemButton
        itemList={itemList}
        setItemList={setItemList}
        selectedItem={selectedItem}
      />
      <br />

      <CalculateGSTButton calulateGST={calulateGST} />
      <br />

      Final Price: {finalPrice}
    </div>
  );
}

export default App;
