<?php

namespace App\Http\Controllers;

use App\Models\Favorite;
use GuzzleHttp\Client;
use Illuminate\Http\Request;

class FavoriteController extends Controller
{

    function searsh($name){
        $client = new Client();
$response = $client->request('GET', 'http://universities.hipolabs.com/search?country='.$name);
$body = $response->getBody();
$data = json_decode($body);
dd($data);
    }
  
    public function index()
    {
        //
        $fav = Favorite::all();
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

    function store(Request $request)
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