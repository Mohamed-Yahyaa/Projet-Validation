import axios from "axios";

import React , { useState, useEffect }from 'react'

import { SelectedHotel, ShowHotel } from './ShowHotel';
import { Searchh } from './Searchh';

function Hotel() {
    const [message, setMessage] = useState('');
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false)
    const [currentPage, setCurrentPage] = useState(1)
    const [HotelPerPage, setHotelPerPage] = useState(8)
    const [dataSelected, setDataSelected] = useState([])
    const [show, setShow] = useState(true)
    
    const fetchData = async() =>{
        setLoading(true)
        const res = await axios.get('http://universities.hipolabs.com/search?')
        
        setData(res.data)
        setLoading(false)
        
    }
    
    useEffect(()=>{
        fetchData()
    }, 
    [])

    

    //selectHotel
    const selectHotel=(item)=>{
        console.log(item)
        if(dataSelected.length == 0 || !dataSelected.find((e) => e.name == item.name)){
            axios.post('http://127.0.0.1:8000/api/favorite', item)
            .then((res => {
                setDataSelected([...dataSelected,res.data])
                getData()
            }))
        }else{
            message()
        }
    }
    console.log(dataSelected)
    //get selected Data
    const getData = ()=>{
        axios.get('http://127.0.0.1:8000/api/favorite').then((res=>{
            setDataSelected(res.data)
       }))
    }
    useEffect(() => {
        getData()
    }, []);
    
    // deletSelectedData
    const deletSelectedHotel = (item)=>{
        axios.delete(`http://127.0.0.1:8000/api/favorite/${item.id}`).then((res)=>{
            getData()
        })
    }

  return (
  
 
        <><ShowHotel data={data} setData={setData} selectHotel={selectHotel} show={show} setShow={setShow}/>

        
        <SelectedHotel dataSelected={dataSelected} deletSelectedHotel={deletSelectedHotel} show={show} setShow={setShow}/></>
        

  )
}

export default Hotel