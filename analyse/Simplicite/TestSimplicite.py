import unittest
import Simplicite

class TestSimplicite(unittest.TestCase):
    
    def test_rle(self):
        self.assertEqual("", Simplicite.RLE(""))
        self.assertEqual("1a1b1c", Simplicite.RLE("abc"))
        self.assertEqual("1a2b3c", Simplicite.RLE("abbccc"))
        self.assertEqual("3a1b2a", Simplicite.RLE("aaabaa"))
        self.assertEqual("1a1A1a", Simplicite.RLE("aAa"))
        self.assertEqual("9W4W", Simplicite.RLE("WWWWWWWWWWWWW"))

    def test_rle_recursif(self):
        self.assertEqual("", Simplicite.RLE_recursive("", 1))
        self.assertEqual("", Simplicite.RLE_recursive("", 3))

        self.assertEqual("1a1b1c", Simplicite.RLE_recursive("abc", 1))
        self.assertEqual("1a2b3c", Simplicite.RLE_recursive("abbccc", 1))
        self.assertEqual("3a1b2a", Simplicite.RLE_recursive("aaabaa", 1))
        self.assertEqual("1a1A1a", Simplicite.RLE_recursive("aAa", 1))

        self.assertEqual("111a111b111c", Simplicite.RLE_recursive("abc", 2))
        self.assertEqual("311a311b311c", Simplicite.RLE_recursive("abc", 3))

if __name__ == '__main__':
    unittest.main()