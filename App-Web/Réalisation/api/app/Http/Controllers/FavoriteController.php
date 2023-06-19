<?php

namespace App\Http\Controllers;

use App\Models\Favorite;
use Illuminate\Http\Request;

class FavoriteController extends Controller
{
  
    public function index()
    {
        //
        $fav = Favorite::all();
        return $fav;
    }



    public function store(Request $request)
    {
        //
        $fav = Favorite::create([

            'country' => json_encode($request->country),
            'name' => json_encode($request->name),
            'web_pages' => json_encode($request->web_pages), 
           
        ]);
        return $fav;
    }
    

    public function destroy($id)
    {
        //
        $fav = Favorite::findOrFail($id);
        return $fav->delete();
    }

    function  getItem($params)
    {

        $client = new \GuzzleHttp\Client([
            'verify' => false,
        ]);

        $response = $client->request('GET', "http://universities.hipolabs.com/search?country=" . $params);

        $data = json_decode($response->getBody(), true);
        $firstTwenty = array_slice($data, 0, 20);

        $array = array();
        foreach ($firstTwenty as $value) {
            $array[]  =
                array(
                    "name" =>  $value['name'],
                    "country" =>  $value['country'],
                    "web_pages" =>  $value['web_pages'][0]
                );

        }




        return $array;
    }

    function store_mob(Request $request)
    {

        $league = new Favorite();

        $league->name = $request->name;
        $league->country = $request->country;
        $league->web_pages = $request->web_pages;

        $league->save();
        return true;
    }
    function ListFavorite(){
        $getAll = Favorite::all();
        return $getAll;
    }
    function deletee($name){
      
        $getAll = Favorite::where("name",$name)->delete();
        return $getAll;
    }

}