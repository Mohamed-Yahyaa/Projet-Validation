import React from 'react'
import axios from'axios'

export const Searchh = ({setData, data}) => {
  const Search = async(e) => {
    const res =  await axios.get('http://universities.hipolabs.com/search?country='+e.target.value)
    setData(res.data)
    console.log(data)
  }
  return (



    <div class="sear ">
    <div class="btn search">
        <input type="text" class="form-control" placeholder="Search"onChange={Search}/>
     
    </div>
</div> 

  )
}
