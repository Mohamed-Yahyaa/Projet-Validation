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
}