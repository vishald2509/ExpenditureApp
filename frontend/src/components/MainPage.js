import React, { Component } from 'react';
import styled from 'styled-components';

class MainPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      item: '',
      price: '',
      itemlist: []
    };
  }
  //   Controlled Input
  onUpdate = e => {
    //   Update
    this.setState({ [e.target.name]: e.target.value });
  };
  //   Add Item TO DB
  addItem = e => {
    e.preventDefault();
    const expenditure = {
      expenditureName: this.state.item,
      price: this.state.price
    };

    fetch('/add', {
      method: 'POST',
      body: JSON.stringify(expenditure),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
        Accept: 'application/json'
      }
    });
    this.getItems();
  };

  //   Fetch from DB
  getItems = () => {
    fetch('/getexpenditure', {
      method: 'GET',
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
        Accept: 'application/json'
      }
    })
      .then(response => response.json())
      .then(json => {
        this.setState({
          itemlist: json
        });
      });
  };

  render() {
    return (
      <div className='container'>
        <h1>Welcome to my Website</h1>
        <div className='row'>
          <div className='col-6'>
            <form>
              <input
                type='text'
                name='item'
                id='item'
                placeholder='Enter Item'
                value={this.state.item}
                onChange={this.onUpdate}
              />
              <br />
              <br />

              <input
                type='text'
                name='price'
                id='price'
                placeholder='Enter Price'
                value={this.state.price}
                onChange={this.onUpdate}
              />
              <br />
              <br />
              <button onClick={this.addItem}>ADD</button>
            </form>
          </div>
          <div className='col-6'>
            <button onClick={this.getItems}>GET</button>
            <DisplayWrapper>
              {this.state.itemlist.length > 0 ? (
                <React.Fragment>
                  <ListWrapper name='true'>Expenditure</ListWrapper>
                  <ListWrapper>Price</ListWrapper>

                  {// map here
                  this.state.itemlist.map(item => (
                    <React.Fragment key={item.id}>
                      <br />
                      <br />
                      <ListWrapper name='true'>{item.expenditure_name}</ListWrapper>
                      <ListWrapper>{item.price}</ListWrapper>
                    </React.Fragment>
                  ))}
                </React.Fragment>
              ) : (
                ''
              )}
            </DisplayWrapper>
          </div>
        </div>
      </div>
    );
  }
}
export const DisplayWrapper = styled.div`
  margin-top: 20px;
`;

export const ListWrapper = styled.div`
  float: left;
  text-transform: capitalize;
  font-size: 1.4rem;
  background: ${props => (props.name ? 'var(--lightBlue)' : 'var(--ligthDark)')};
  padding: 0.2rem 0.5rem;
  min-width: 10rem;
  text-align: center;
`;

export default MainPage;
