module LibSpec where
import Test.Hspec

spec =
  describe "Prelude.head" $
    it "returns the first element of a list" $
      head [23 ..] `shouldBe` (23 :: Int)
