{-# LANGUAGE OverloadedStrings #-}

module Main where

import Lib
import Web.Scotty

main = scotty 3000 $
  get "/:word" $ do
    beam <- param "word"
    html $ mconcat ["<h1>Scotty, ", beam, " me up!</h1>"]
