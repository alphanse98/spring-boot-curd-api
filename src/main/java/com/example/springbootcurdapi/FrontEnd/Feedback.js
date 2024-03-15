import React, { useEffect, useState } from "react";
import axios from "axios";
import './App.css';


const Feedback = () => {
  const [feedbackLIst, setFeedbackLIst] = useState([]);
  const [feedbackForm, setFeedbackForm] = useState({
    bookName: "",
    feedback: "",
    name: "",
  });

  // get api call
  const getData = async () => {
    try {
      const res = await axios.get("http://localhost:8080/get/feedback");
      setFeedbackLIst(res?.data);
    } catch (error) {
      console.log(error);
    }
  };

  // update input values
  //   @e events
  const updateValue = (e) => {
    let temCopy = { ...feedbackForm };
    temCopy[e.target.name] = e.target.value;
    setFeedbackForm(temCopy);
  };

  // post api call
  const submit = async () => {
    try {
      await axios.post("http://localhost:8080/get/feedback", feedbackForm);
      await getData(); // refetch data
      await alert("Feedback Saved");
    } catch (error) {
      console.log(error);
    }

  };
       

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      {" "}
      <p>2 Feedback Task</p>
      <div>
        <p>Add Feedback</p>
        <div>
          <span>Your name : </span>
          <input
            type="text"
            name="name"
            value={feedbackForm?.name}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <div>
          <span>book Name : </span>
          <input
            type="text"
            name="bookName"
            value={feedbackForm?.bookName}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <div>
          <span>feedback : </span>
          <input
            type="text"
            name="feedback"
            value={feedbackForm?.feedback}
            onChange={(e) => updateValue(e)}
          ></input>
        </div>
        <button onClick={() => submit()}>submit</button>
      </div>
      {/* <--------------------- table ui --------------------->  */}
      <div >
      <table className="center">
        <tr>
          <th>Name</th>
          <th>Book name </th>
          <th>feedback </th>
        </tr>

        {feedbackLIst?.map((item) => (
          <tr key={item?.id}>
            <td>{item?.name}</td>
            <td>{item?.bookName}</td>
            <td>{item?.feedback}</td>
          </tr>
        ))}
      </table>
      </div>
    </div>
  );
};

export default Feedback;
