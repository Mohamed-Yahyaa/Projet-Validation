import React, { Component } from "react";
import axios from "axios";



export default class Stagiare extends Component {
    constructor(props){
        super(props)
        this.state = {
            data : [],
            message : '',
            selectedData : []
        }
    }
    getData = (e) => {
        axios.get('http://127.0.0.1:8000/api/search/'+e.target.value).then((res) => {
          this.setState({
            data: res.data
          });
        });
      };

      
      selectData = (item)=> {
        if(!this.state.selectedData.includes(item)){
            this.setState({
                selectedData : [...this.state.selectedData, item]
            })
        }
        let filteredArray = this.state.data.filter(key => key !== item)
        this.setState({data: filteredArray});
      }

      removeData = (item)=>{
            let filteredArray = this.state.selectedData.filter(key => key !== item)
            this.setState({selectedData: filteredArray});
            this.setState({
                data : [...this.state.data, item]
            })
      }

  render() {
    return (
      <div className='container'>
     
      
        <div className='row'>
            <div className='col-md-6'>
            <input type='search' placeholder='Search' onChange={this.getData}  className='form-control'/>
            <table class="table">
                <thead>
                    <tr>
                    <th scope="col">First Name</th>
                    
                    </tr>
                </thead>
                <tbody>
                    {this.state.data.map((item) => (
                        <tr>
                            <td>{item?.Nom}</td>
                            {/* <td>{item?.Prenom}</td> */}
                            <td><button class="btn btn-outline-success" onClick={ () => this.selectData(item)}>+</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
            </div>
            <div className='col-md-6'>
                <table class="table">
                    <thead>
                        <tr>
                        <th scope="col">First Name</th>
                     
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.selectedData.map((item => 
                            <tr>
                                <td>{item?.Nom}</td>
                                <td></td>
                                <td><button class="btn btn-outline-success" onClick={ () => this.removeData(item)}>-</button></td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            </div>
      </div>
    )
  }
}

