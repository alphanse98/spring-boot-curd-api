import React, { useEffect, useState } from "react";
import axios from "axios";

const Catalog = () => {
  const [catalogList, setCatalogList] = useState([]);
  const [catalogData, setcatalogData] = useState({
    productName: "",
    price: "",
    catalog: "",
  });

  // update input values
  const updateValue = (e) => {
    const { name, value } = e.target;
    setcatalogData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // post api call
  const sentcatalogData = async () => {
    try {
      await axios.post("http://localhost:8080/create/catalog", catalogData);
      await getData(); // refetch data
      await alert("success fully addet");
    } catch (error) {
      console.log(error);
    }
  };

  // get api call
  const getData = async () => {
    try {
      const res = await axios.get("http://localhost:8080/get/catalog");
      setCatalogList(res?.data);
    } catch (error) {}
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      <p>1 catalog Task</p>
      <div>
        <p>Add productName</p>
        <div>
          <span>product Name : </span>
          <input
            type="text"
            name="productName"
            value={catalogData?.productName}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <div>
          <span>price : </span>
          <input
            type="number"
            name="price"
            value={catalogData?.price}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <div>
          <span>catalog : </span>
          <input
            type="text"
            name="catalog"
            value={catalogData?.catalog}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <button onClick={() => sentcatalogData()}>Add productName</button>
      </div>

      {/* <--------------------- table ui --------------------->  */}
      <table className="center">
        <tr>
          <th>Name</th>
          <th>price</th>
          <th>catalog</th>
        </tr>

        {catalogList?.map((item) => (
          <tr key={item?.id}>
            <td>{item?.productName}</td>
            <td>{item?.price}</td>
            <td>{item?.catalog}</td>
          </tr>
        ))}
      </table>
    </div>
  );
};

export default Catalog;
