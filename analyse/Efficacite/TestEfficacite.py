import unittest
import Efficacite

class TestEfficacite(unittest.TestCase):
    
    def test_rle(self):
        self.assertEqual("", Efficacite.encodage_rle(""))
        self.assertEqual("1a1b1c", Efficacite.encodage_rle("abc"))
        self.assertEqual("1a2b3c", Efficacite.encodage_rle("abbccc"))
        self.assertEqual("3a1b2a", Efficacite.encodage_rle("aaabaa"))
        self.assertEqual("1a1A1a", Efficacite.encodage_rle("aAa"))
        self.assertEqual("9W4W", Efficacite.encodage_rle("WWWWWWWWWWWWW"))

    def test_rle_recursif(self):
        self.assertEqual("", Efficacite.RLE_recursive("", 1))
        self.assertEqual("", Efficacite.RLE_recursive("", 3))

        self.assertEqual("1a1b1c", Efficacite.RLE_recursive("abc", 1))
        self.assertEqual("1a2b3c", Efficacite.RLE_recursive("abbccc", 1))
        self.assertEqual("3a1b2a", Efficacite.RLE_recursive("aaabaa", 1))
        self.assertEqual("1a1A1a", Efficacite.RLE_recursive("aAa", 1))

        self.assertEqual("111a111b111c", Efficacite.RLE_recursive("abc", 2))
        self.assertEqual("311a311b311c", Efficacite.RLE_recursive("abc", 3))

if __name__ == '__main__':
    unittest.main()