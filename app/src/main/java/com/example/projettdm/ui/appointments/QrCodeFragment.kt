package com.example.projettdm.ui.appointments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.example.projettdm.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.zxing.WriterException
import kotlinx.android.synthetic.main.bottom_sheet_qrcode.*


class QrCodeFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_qrcode,container,false)
    }

    @SuppressLint("ResourceType", "UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manager = getActivity()?.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
        val display = manager!!.defaultDisplay
        val point = Point()
        display.getSize(point)
        val width: Int = point.x
        val height: Int = point.y
        var dimen = if (width < height) width else height
        dimen = dimen * 3 / 4
        val idRDV=arguments?.getInt("idRDV").toString()
        val qrgEncoder = QRGEncoder(idRDV, null, QRGContents.Type.TEXT, dimen)
        try {
            val bitmap = qrgEncoder.encodeAsBitmap()
            qrCodeView.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            Log.e("Tag", e.toString())
        }
        submit_advice.setOnClickListener{
            this.dismiss()
        }
    }
}