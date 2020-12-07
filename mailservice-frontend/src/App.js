import React, { Component } from 'react';
import './App.css';
import { reduxForm, Field } from 'redux-form';

let MessageForm = props => {
  const { handleSubmit } = props;
  return <form onSubmit={handleSubmit} className="form" id="mail-form">
    <div className="field">
      <div className="control">
        <label className="label">e-mail address</label>
        <Field className="input" name="email" component="input" type="text" placeholder="email" />
      </div>
    </div>

    <div className="field">
      <div className="control">
        <label className="label">subject</label>
        <Field className="input" name="subject" component="input" type="text" placeholder="subject" />
      </div>
    </div>

    <div className="field">
      <div className="control">
        <label className="label">body</label>
        <Field className="textarea" name="body" component="textarea" placeholder="message body" />
      </div>
    </div>

    <div className="field">
      <div className="control">
        <button className="button is-link">Submit</button>
      </div>
    </div>

  </form>;
};

MessageForm = reduxForm({
  form: 'signIn',
})(MessageForm);

class App extends Component {
  handleSendMessage = values => {
    console.log(values);
    fetch('http://localhost:8080/api/message', {
      method: 'POST',
      body: JSON.stringify(values),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(function(response) {
      console.log(response);
    });
  };

  render() {
    return (
      <div className="App" >
        <div className="container">
          <p className="App-intro">
            mail message form
      </p>
          <MessageForm onSubmit={this.handleSendMessage} />
        </div>
      </div>
    )
  };
}

export default App;
